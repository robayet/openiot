/**
*    Copyright (c) 2011-2014, OpenIoT
*   
*    This file is part of OpenIoT.
*
*    OpenIoT is free software: you can redistribute it and/or modify
*    it under the terms of the GNU Lesser General Public License as published by
*    the Free Software Foundation, version 3 of the License.
*
*    OpenIoT is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU Lesser General Public License for more details.
*
*    You should have received a copy of the GNU Lesser General Public License
*    along with OpenIoT.  If not, see <http://www.gnu.org/licenses/>.
*
*     Contact: OpenIoT mailto: info@openiot.eu
*/

package org.openiot.gsn.wrappers.tinyos;

/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'RuedlingenData'
 * message type.
 */

public class RuedlingenData extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 26;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 128;

    /** Create a new RuedlingenData of size 26. */
    public RuedlingenData() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new RuedlingenData of the given data_length. */
    public RuedlingenData(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData with the given data_length
     * and base offset.
     */
    public RuedlingenData(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData using the given byte array
     * as backing store.
     */
    public RuedlingenData(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData using the given byte array
     * as backing store, with the given base offset.
     */
    public RuedlingenData(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public RuedlingenData(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData embedded in the given message
     * at the given base offset.
     */
    public RuedlingenData(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new RuedlingenData embedded in the given message
     * at the given base offset and length.
     */
    public RuedlingenData(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <RuedlingenData> \n";
      try {
        s += "  [ntw_sender_id=0x"+Long.toHexString(get_ntw_sender_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [ntw_cost_to_bs=0x"+Long.toHexString(get_ntw_cost_to_bs())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [tsp_hop_count=0x"+Long.toHexString(get_tsp_hop_count())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [tsp_packet_sn=0x"+Long.toHexString(get_tsp_packet_sn())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [reporter_id=0x"+Long.toHexString(get_reporter_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [timestamp=0x"+Long.toHexString(get_timestamp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [rainmeter=0x"+Long.toHexString(get_rainmeter())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [windspeed=0x"+Long.toHexString(get_windspeed())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [watermark=0x"+Long.toHexString(get_watermark())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [airhumidity=0x"+Long.toHexString(get_airhumidity())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soilmoisture=0x"+Long.toHexString(get_soilmoisture())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [winddirection=0x"+Long.toHexString(get_winddirection())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [solarradiation=0x"+Long.toHexString(get_solarradiation())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [airtemperature=0x"+Long.toHexString(get_airtemperature())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [skintemperature=0x"+Long.toHexString(get_skintemperature())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: ntw_sender_id
    //   Field type: short, unsigned
    //   Offset (bits): 0
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'ntw_sender_id' is signed (false).
     */
    public static boolean isSigned_ntw_sender_id() {
        return false;
    }

    /**
     * Return whether the field 'ntw_sender_id' is an array (false).
     */
    public static boolean isArray_ntw_sender_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'ntw_sender_id'
     */
    public static int offset_ntw_sender_id() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'ntw_sender_id'
     */
    public static int offsetBits_ntw_sender_id() {
        return 0;
    }

    /**
     * Return the value (as a short) of the field 'ntw_sender_id'
     */
    public short get_ntw_sender_id() {
        return (short)getUIntBEElement(offsetBits_ntw_sender_id(), 8);
    }

    /**
     * Set the value of the field 'ntw_sender_id'
     */
    public void set_ntw_sender_id(short value) {
        setUIntBEElement(offsetBits_ntw_sender_id(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'ntw_sender_id'
     */
    public static int size_ntw_sender_id() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'ntw_sender_id'
     */
    public static int sizeBits_ntw_sender_id() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: ntw_cost_to_bs
    //   Field type: short, unsigned
    //   Offset (bits): 8
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'ntw_cost_to_bs' is signed (false).
     */
    public static boolean isSigned_ntw_cost_to_bs() {
        return false;
    }

    /**
     * Return whether the field 'ntw_cost_to_bs' is an array (false).
     */
    public static boolean isArray_ntw_cost_to_bs() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'ntw_cost_to_bs'
     */
    public static int offset_ntw_cost_to_bs() {
        return (8 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'ntw_cost_to_bs'
     */
    public static int offsetBits_ntw_cost_to_bs() {
        return 8;
    }

    /**
     * Return the value (as a short) of the field 'ntw_cost_to_bs'
     */
    public short get_ntw_cost_to_bs() {
        return (short)getUIntBEElement(offsetBits_ntw_cost_to_bs(), 8);
    }

    /**
     * Set the value of the field 'ntw_cost_to_bs'
     */
    public void set_ntw_cost_to_bs(short value) {
        setUIntBEElement(offsetBits_ntw_cost_to_bs(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'ntw_cost_to_bs'
     */
    public static int size_ntw_cost_to_bs() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'ntw_cost_to_bs'
     */
    public static int sizeBits_ntw_cost_to_bs() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: tsp_hop_count
    //   Field type: short, unsigned
    //   Offset (bits): 16
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'tsp_hop_count' is signed (false).
     */
    public static boolean isSigned_tsp_hop_count() {
        return false;
    }

    /**
     * Return whether the field 'tsp_hop_count' is an array (false).
     */
    public static boolean isArray_tsp_hop_count() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'tsp_hop_count'
     */
    public static int offset_tsp_hop_count() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'tsp_hop_count'
     */
    public static int offsetBits_tsp_hop_count() {
        return 16;
    }

    /**
     * Return the value (as a short) of the field 'tsp_hop_count'
     */
    public short get_tsp_hop_count() {
        return (short)getUIntBEElement(offsetBits_tsp_hop_count(), 8);
    }

    /**
     * Set the value of the field 'tsp_hop_count'
     */
    public void set_tsp_hop_count(short value) {
        setUIntBEElement(offsetBits_tsp_hop_count(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'tsp_hop_count'
     */
    public static int size_tsp_hop_count() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'tsp_hop_count'
     */
    public static int sizeBits_tsp_hop_count() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: tsp_packet_sn
    //   Field type: short, unsigned
    //   Offset (bits): 24
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'tsp_packet_sn' is signed (false).
     */
    public static boolean isSigned_tsp_packet_sn() {
        return false;
    }

    /**
     * Return whether the field 'tsp_packet_sn' is an array (false).
     */
    public static boolean isArray_tsp_packet_sn() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'tsp_packet_sn'
     */
    public static int offset_tsp_packet_sn() {
        return (24 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'tsp_packet_sn'
     */
    public static int offsetBits_tsp_packet_sn() {
        return 24;
    }

    /**
     * Return the value (as a short) of the field 'tsp_packet_sn'
     */
    public short get_tsp_packet_sn() {
        return (short)getUIntBEElement(offsetBits_tsp_packet_sn(), 8);
    }

    /**
     * Set the value of the field 'tsp_packet_sn'
     */
    public void set_tsp_packet_sn(short value) {
        setUIntBEElement(offsetBits_tsp_packet_sn(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'tsp_packet_sn'
     */
    public static int size_tsp_packet_sn() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'tsp_packet_sn'
     */
    public static int sizeBits_tsp_packet_sn() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: reporter_id
    //   Field type: short, unsigned
    //   Offset (bits): 32
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'reporter_id' is signed (false).
     */
    public static boolean isSigned_reporter_id() {
        return false;
    }

    /**
     * Return whether the field 'reporter_id' is an array (false).
     */
    public static boolean isArray_reporter_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'reporter_id'
     */
    public static int offset_reporter_id() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'reporter_id'
     */
    public static int offsetBits_reporter_id() {
        return 32;
    }

    /**
     * Return the value (as a short) of the field 'reporter_id'
     */
    public short get_reporter_id() {
        return (short)getUIntBEElement(offsetBits_reporter_id(), 8);
    }

    /**
     * Set the value of the field 'reporter_id'
     */
    public void set_reporter_id(short value) {
        setUIntBEElement(offsetBits_reporter_id(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'reporter_id'
     */
    public static int size_reporter_id() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'reporter_id'
     */
    public static int sizeBits_reporter_id() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: timestamp
    //   Field type: long, unsigned
    //   Offset (bits): 40
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'timestamp' is signed (false).
     */
    public static boolean isSigned_timestamp() {
        return false;
    }

    /**
     * Return whether the field 'timestamp' is an array (false).
     */
    public static boolean isArray_timestamp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'timestamp'
     */
    public static int offset_timestamp() {
        return (40 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'timestamp'
     */
    public static int offsetBits_timestamp() {
        return 40;
    }

    /**
     * Return the value (as a long) of the field 'timestamp'
     */
    public long get_timestamp() {
        return (long)getUIntBEElement(offsetBits_timestamp(), 32);
    }

    /**
     * Set the value of the field 'timestamp'
     */
    public void set_timestamp(long value) {
        setUIntBEElement(offsetBits_timestamp(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'timestamp'
     */
    public static int size_timestamp() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'timestamp'
     */
    public static int sizeBits_timestamp() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: rainmeter
    //   Field type: short, unsigned
    //   Offset (bits): 72
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'rainmeter' is signed (false).
     */
    public static boolean isSigned_rainmeter() {
        return false;
    }

    /**
     * Return whether the field 'rainmeter' is an array (false).
     */
    public static boolean isArray_rainmeter() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'rainmeter'
     */
    public static int offset_rainmeter() {
        return (72 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'rainmeter'
     */
    public static int offsetBits_rainmeter() {
        return 72;
    }

    /**
     * Return the value (as a short) of the field 'rainmeter'
     */
    public short get_rainmeter() {
        return (short)getUIntBEElement(offsetBits_rainmeter(), 8);
    }

    /**
     * Set the value of the field 'rainmeter'
     */
    public void set_rainmeter(short value) {
        setUIntBEElement(offsetBits_rainmeter(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'rainmeter'
     */
    public static int size_rainmeter() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'rainmeter'
     */
    public static int sizeBits_rainmeter() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: windspeed
    //   Field type: int, unsigned
    //   Offset (bits): 80
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'windspeed' is signed (false).
     */
    public static boolean isSigned_windspeed() {
        return false;
    }

    /**
     * Return whether the field 'windspeed' is an array (false).
     */
    public static boolean isArray_windspeed() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'windspeed'
     */
    public static int offset_windspeed() {
        return (80 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'windspeed'
     */
    public static int offsetBits_windspeed() {
        return 80;
    }

    /**
     * Return the value (as a int) of the field 'windspeed'
     */
    public int get_windspeed() {
        return (int)getUIntBEElement(offsetBits_windspeed(), 16);
    }

    /**
     * Set the value of the field 'windspeed'
     */
    public void set_windspeed(int value) {
        setUIntBEElement(offsetBits_windspeed(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'windspeed'
     */
    public static int size_windspeed() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'windspeed'
     */
    public static int sizeBits_windspeed() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: watermark
    //   Field type: int, unsigned
    //   Offset (bits): 96
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'watermark' is signed (false).
     */
    public static boolean isSigned_watermark() {
        return false;
    }

    /**
     * Return whether the field 'watermark' is an array (false).
     */
    public static boolean isArray_watermark() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'watermark'
     */
    public static int offset_watermark() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'watermark'
     */
    public static int offsetBits_watermark() {
        return 96;
    }

    /**
     * Return the value (as a int) of the field 'watermark'
     */
    public int get_watermark() {
        return (int)getUIntBEElement(offsetBits_watermark(), 16);
    }

    /**
     * Set the value of the field 'watermark'
     */
    public void set_watermark(int value) {
        setUIntBEElement(offsetBits_watermark(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'watermark'
     */
    public static int size_watermark() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'watermark'
     */
    public static int sizeBits_watermark() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: airhumidity
    //   Field type: int, unsigned
    //   Offset (bits): 112
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'airhumidity' is signed (false).
     */
    public static boolean isSigned_airhumidity() {
        return false;
    }

    /**
     * Return whether the field 'airhumidity' is an array (false).
     */
    public static boolean isArray_airhumidity() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'airhumidity'
     */
    public static int offset_airhumidity() {
        return (112 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'airhumidity'
     */
    public static int offsetBits_airhumidity() {
        return 112;
    }

    /**
     * Return the value (as a int) of the field 'airhumidity'
     */
    public int get_airhumidity() {
        return (int)getUIntBEElement(offsetBits_airhumidity(), 16);
    }

    /**
     * Set the value of the field 'airhumidity'
     */
    public void set_airhumidity(int value) {
        setUIntBEElement(offsetBits_airhumidity(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'airhumidity'
     */
    public static int size_airhumidity() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'airhumidity'
     */
    public static int sizeBits_airhumidity() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soilmoisture
    //   Field type: int, unsigned
    //   Offset (bits): 128
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soilmoisture' is signed (false).
     */
    public static boolean isSigned_soilmoisture() {
        return false;
    }

    /**
     * Return whether the field 'soilmoisture' is an array (false).
     */
    public static boolean isArray_soilmoisture() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soilmoisture'
     */
    public static int offset_soilmoisture() {
        return (128 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soilmoisture'
     */
    public static int offsetBits_soilmoisture() {
        return 128;
    }

    /**
     * Return the value (as a int) of the field 'soilmoisture'
     */
    public int get_soilmoisture() {
        return (int)getUIntBEElement(offsetBits_soilmoisture(), 16);
    }

    /**
     * Set the value of the field 'soilmoisture'
     */
    public void set_soilmoisture(int value) {
        setUIntBEElement(offsetBits_soilmoisture(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'soilmoisture'
     */
    public static int size_soilmoisture() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'soilmoisture'
     */
    public static int sizeBits_soilmoisture() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: winddirection
    //   Field type: int, unsigned
    //   Offset (bits): 144
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'winddirection' is signed (false).
     */
    public static boolean isSigned_winddirection() {
        return false;
    }

    /**
     * Return whether the field 'winddirection' is an array (false).
     */
    public static boolean isArray_winddirection() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'winddirection'
     */
    public static int offset_winddirection() {
        return (144 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'winddirection'
     */
    public static int offsetBits_winddirection() {
        return 144;
    }

    /**
     * Return the value (as a int) of the field 'winddirection'
     */
    public int get_winddirection() {
        return (int)getUIntBEElement(offsetBits_winddirection(), 16);
    }

    /**
     * Set the value of the field 'winddirection'
     */
    public void set_winddirection(int value) {
        setUIntBEElement(offsetBits_winddirection(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'winddirection'
     */
    public static int size_winddirection() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'winddirection'
     */
    public static int sizeBits_winddirection() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: solarradiation
    //   Field type: int, unsigned
    //   Offset (bits): 160
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'solarradiation' is signed (false).
     */
    public static boolean isSigned_solarradiation() {
        return false;
    }

    /**
     * Return whether the field 'solarradiation' is an array (false).
     */
    public static boolean isArray_solarradiation() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'solarradiation'
     */
    public static int offset_solarradiation() {
        return (160 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'solarradiation'
     */
    public static int offsetBits_solarradiation() {
        return 160;
    }

    /**
     * Return the value (as a int) of the field 'solarradiation'
     */
    public int get_solarradiation() {
        return (int)getUIntBEElement(offsetBits_solarradiation(), 16);
    }

    /**
     * Set the value of the field 'solarradiation'
     */
    public void set_solarradiation(int value) {
        setUIntBEElement(offsetBits_solarradiation(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'solarradiation'
     */
    public static int size_solarradiation() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'solarradiation'
     */
    public static int sizeBits_solarradiation() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: airtemperature
    //   Field type: int, unsigned
    //   Offset (bits): 176
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'airtemperature' is signed (false).
     */
    public static boolean isSigned_airtemperature() {
        return false;
    }

    /**
     * Return whether the field 'airtemperature' is an array (false).
     */
    public static boolean isArray_airtemperature() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'airtemperature'
     */
    public static int offset_airtemperature() {
        return (176 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'airtemperature'
     */
    public static int offsetBits_airtemperature() {
        return 176;
    }

    /**
     * Return the value (as a int) of the field 'airtemperature'
     */
    public int get_airtemperature() {
        return (int)getUIntBEElement(offsetBits_airtemperature(), 16);
    }

    /**
     * Set the value of the field 'airtemperature'
     */
    public void set_airtemperature(int value) {
        setUIntBEElement(offsetBits_airtemperature(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'airtemperature'
     */
    public static int size_airtemperature() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'airtemperature'
     */
    public static int sizeBits_airtemperature() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: skintemperature
    //   Field type: int, unsigned
    //   Offset (bits): 192
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'skintemperature' is signed (false).
     */
    public static boolean isSigned_skintemperature() {
        return false;
    }

    /**
     * Return whether the field 'skintemperature' is an array (false).
     */
    public static boolean isArray_skintemperature() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'skintemperature'
     */
    public static int offset_skintemperature() {
        return (192 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'skintemperature'
     */
    public static int offsetBits_skintemperature() {
        return 192;
    }

    /**
     * Return the value (as a int) of the field 'skintemperature'
     */
    public int get_skintemperature() {
        return (int)getUIntBEElement(offsetBits_skintemperature(), 16);
    }

    /**
     * Set the value of the field 'skintemperature'
     */
    public void set_skintemperature(int value) {
        setUIntBEElement(offsetBits_skintemperature(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'skintemperature'
     */
    public static int size_skintemperature() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'skintemperature'
     */
    public static int sizeBits_skintemperature() {
        return 16;
    }

}
